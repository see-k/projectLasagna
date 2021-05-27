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
    const [newSighting, setNewSighting] = useState();
 
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
            setAddNew(false)
            setMarker(null);
            })
            .catch(console.log);
        }
        

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
        setMarker(null);
        setAddNew(false);
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
                <AddSighting latitude={marker.lat} longitude={marker.lng} time={marker.time} addSighting={addSighting} cancel={removeMarker}
            />)}

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

                {/* if selected show sighting find by id */}
                {selected ? (
                    <InfoWindow
                        position={{ lat: selected.latitude, lng: selected.longitude }}
                        onCloseClick={setSelected(null)}
                        >
                        <div><p>a window!</p></div> 
                        
                        {/* <Sighting 
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
                            removeSighting = {removeSighting}
                        /> */}
                    </InfoWindow>) : null} 
            </GoogleMap>
        </div>
    );
}

export default SightingsMap;
