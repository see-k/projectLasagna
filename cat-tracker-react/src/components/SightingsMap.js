import './../App.css';
import Sighting from './Sighting';
import { React, useEffect, useState } from 'react';
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
   /* const [sightings, setSightings] = useState([]);
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
    }, []) */

    const [markers, setMarkers] = useState([]);

    const addSighting = (event) => {
        setMarkers(current => [...current, {
            lat: event.latLng.lat(),
            lng: event.latLng.lng(),
            time: new Date(),
        }])
    }
    
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
            onClick={addSighting}>
                {markers.map(marker => 
                    <Marker 
                        key={marker.time.toISOString} 
                        position={{lat: marker.lat, lng: marker.lng}}    
                    />
                )}
            </GoogleMap>
        </div>
    );
}

export default SightingsMap;
