import './../App.css';
import Sighting from './Sighting';
import AddSighting from './AddSighting';
import { React, useEffect, useState, useCallback, useRef } from 'react';
import { GoogleMap, useLoadScript, Marker, InfoWindow } from '@react-google-maps/api';
import { Modal } from 'react-bootstrap';

const mapContainerStyle = {
    width: '100vw',
    height: '100vh'
}

const center = {
    lat: 44.986656,
    lng: 	-93.258133
}

const options = {
    disableDefaultUI: true,
    zoomControl: true
}

const icon = {
    url: '/cat_icons/cat_map_marker.png'
}

function SightingsMap() {
    const [sightings, setSightings] = useState([]);
    const [messages, setMessages] = useState("");
    //const [newSighting, setNewSighting] = useState();
 
    useEffect(() => {
        fetch("http://localhost:8080/api/sighting")
        .then((response) => {
            if (response.status !== 200) {
                console.log(response);
                return Promise.reject("Get request failed");
            }
            return response.json();
        })
        .then((json) => setSightings(json))
        .catch(console.log);
    }, [sightings]) 

    const addFetch = async (sighting) => {
        const init = {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
            },
            body: JSON.stringify(sighting),
        };
    
        await fetch("http://localhost:8080/api/sighting", init)
            .then((response) => {
            if (response.status !== 201) {
                return Promise.reject("Add sighting error.");
            }
            return response.json();
            })
            .then((json) => {
            setSightings([...sightings, json]);
            setMessages("");
            })
            .catch(console.log);

    }

    //modal handling
    const [show, setShow] = useState(true);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
        

    //marker needs to store sighting locations
    const [marker, setMarker] = useState(null);
    const [selected, setSelected] = useState(null);
    const [sightingForm, setSightingForm] = useState(null);

    const [addNew, setAddNew] = useState(false);

    const handleAdd = () => {
        setAddNew(true);
    } 

    const addSighting = (sighting) => {
        let canSet = true;
    
        for (let i = 0; i < sightings.length; i++) {
            if (sighting.sightingId === sightings[i].sightingId) {
            canSet = false;
            }
        }
    
        if (canSet) {
            addFetch(sighting);
            setAddNew(false);
            setMarker(null);
        } else {
            setMessages("Sighting Already Exists");
        }
    };

    const removeSighting = (sightingId) => {
        let newSightings = [];
    
        for (let i = 0; i < sightings.length; i++) {
            if (sightings[i].sightingId !== sightingId) {
            newSightings.push(sightings[i]);
            }
        }
    
        if (newSightings.length !== sightings.length) {
            setSightings(newSightings);
            setSelected(null);
            setMessages("");
        } else {
            setMessages("Could not find that sighting to remove");
        }
    };

    const newMarker = (event) => {
        setMarker({
            lat: event.latLng.lat(),
            lng: event.latLng.lng(),
            time: new Date(),
        });
    };

    const removeMarker = (event) => {
        setAddNew(false);
        setMarker(null);
    }

    const mapRef = useRef();

    const onMapLoad = useCallback((map) => {
        mapRef.current = map;
    }, []);
    
    const {isLoaded, loadError} = useLoadScript({
        googleMapsApiKey: process.env.REACT_APP_API_KEY
    })

    if(loadError) {
        return "Error loading maps.";
    }

    if(!isLoaded) {
        return "Loading...";
    }

    return (
        <div className="App">

            { addNew && ( 
                <Modal 
                        size="lg"
                        show={show}
                        onHide={handleClose}
                        backdrop="static"
                        keyboard={false}
                        animation={false}>
                    <Modal.Header closeButton>
                        Add a Sighting
                    </Modal.Header>
                    <Modal.Body> 
                <AddSighting latitude={marker.lat} longitude={marker.lng} time={marker.time} addSighting={addSighting} cancel={removeMarker}
                    />
                    </Modal.Body>
                    </Modal>)}

            {selected ? ( 
                <Modal 
                        show={show}
                        onHide={handleClose}
                        backdrop="static"
                        keyboard={false}
                        animation={false}
                        aria-labelledby="contained-modal-title-vcenter"
                        centered>
                        
                    <Modal.Header closeButton>
                        <Modal.Title id="contained-modal-title-vcenter">Cat Sighting</Modal.Title>
                    </Modal.Header>
                    <Modal.Body> 
                    <Sighting 
                            key={selected.sightingId} 
                            sightingId={selected.sightingId} 
                            picture={selected.picture}   
                            visualDescription={selected.catDescription}
                            sightingDescription={selected.sightingDescription}
                            sightingDate={selected.sightingDate}
                            sightingTime={selected.sightingTime}
                            latitude={selected.latitude}
                            longitude={selected.longitude}
                            disabled={selected.disabled}
                            usersId={selected.usersId}
                            catId={selected.catId}
                            remove={removeSighting}
                        />
                        </Modal.Body>
                    </Modal>) : null}

            <GoogleMap mapContainerStyle={mapContainerStyle} 
            zoom={10} 
            center={center}
            options={options}
            // onClick={addSighting}
            onClick={newMarker}
            onLoad={onMapLoad}
            >
                {sightings.map(sighting => 
                    <Marker 
                        key={sighting.sightingId} 
                        position={{lat: sighting.latitude, lng: sighting.longitude} }
                        icon={icon}
                        onClick={() => {
                            //store location and pass to new sightings page
                            setSelected(sighting);
                        }}   
                    />
                )}
                
                {marker ? (<Marker 
                    key={marker.time.toISOString} 
                    position={{lat: marker.lat, lng: marker.lng} }
                    icon={{
                        url: '/cat_icons/cat_map_marker.png'
                    }}   
                />) : null }
                 
                {marker ? (<InfoWindow
                    position={{ lat: marker.lat, lng: marker.lng }}
                    onCloseClick={removeMarker}
                        >
                    {/*link to see more in view sightings*/}
                    {/*deleteMarker={deleteMarker(selected.time)}*/}
                    <div>
                        <h2>Add a new Sighting?</h2>
                        <button className="btn btn-secondary" onClick={handleAdd}>yes</button>
                        <button className="btn btn-secondary" onClick={removeMarker}>no</button>
                        {/*<p>Spotted {formatRelative(time, new Date())}</p>*/}
                    </div>
                </InfoWindow>) : null}  
            </GoogleMap>
        </div>
    );
}

export default SightingsMap;
