import './../App.css';
import Sighting from './Sighting';
import { React, useEffect, useState, useCallback, useRef } from 'react';
import { GoogleMap, useLoadScript, Marker, InfoWindow } from '@react-google-maps/api';

const libraries = ["places"];

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
    const [markers, setMarkers] = useState([]);
    const [sighting, setSighting] = useState(null);

    const addSighting = useCallback();

    const addMarker = useCallback((event) => {
        setMarkers(current => [...current, {
            lat: event.latLng.lat(),
            lng: event.latLng.lng(),
            time: new Date(),
        }]);
    }, []);

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
            <GoogleMap mapContainerStyle={mapContainerStyle} 
            zoom={8} 
            center={center}
            options={options}
            onClick={addMarker}
            onLoad={onMapLoad}
            >
                {markers.map(marker => 
                    <Marker 
                        key={marker.time.toISOString} 
                        position={{lat: marker.lat, lng: marker.lng}}
                        icon={{
                            url: '/cat_icons/cat_map_marker.png'
                        }}
                        onClick={() => {
                            //store location and pull to new sightings page
                            setSighting(marker);
                        }}    
                    />
                )}
            </GoogleMap>
        </div>
    );
}

export default SightingsMap;
