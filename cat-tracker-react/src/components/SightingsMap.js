import './../App.css';
import Sighting from './Sighting';
import AddSighting from './AddSighting';
import { React, useEffect, useState, useCallback, useRef } from 'react';
import { GoogleMap, useLoadScript, Marker, InfoWindow } from '@react-google-maps/api';

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
    }, []) 

    //marker needs to store sighting locations
    const [marker, setMarker] = useState(null);
    const [selected, setSelected] = useState(null);
    const [sightingForm, setSightingForm] = useState(null);

    const [addNew, setAddNew] = useState(false);

    const handleAdd = () => {
        setAddNew(true);
    } 

    const addSighting = useCallback((event) => {
        setSightings(current => [...current, {
            lat: event.latLng.lat(),
            lng: event.latLng.lng(),
            time: new Date(),
        }]); 
    }, []);

    const newMarker = (event) => {
        setMarker({
            lat: event.latLng.lat(),
            lng: event.latLng.lng(),
            time: new Date(),
        });
    };

    const removeMarker = (event) => {
        setMarker(null);
        setSelected(null);
    }

    const mapRef = useRef();

    const onMapLoad = useCallback((map) => {
        mapRef.current = map;
    }, []);
    
    const {isLoaded, loadError} = useLoadScript({
        googleMapsApiKey: process.env.REACT_APP_API_KEY,
        libraries: ["places"]
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
                <AddSighting latitude={marker.lat} longitude={marker.lng} time={marker.time} addSighting={addSighting}
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
                        icon={{
                            url: '/cat_icons/cat_map_marker.png'
                        }}
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
                    onClick={() => {
                        //store location and pass to new sightings page
                        setSelected(marker);
                    }}    
                />) : null }
                 
                {selected ? (<InfoWindow
                    position={{ lat: selected.lat, lng: selected.lng }}
                    onCloseClick={() =>
                            { setSelected(null);
                            }}
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
