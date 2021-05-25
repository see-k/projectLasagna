import './../App.css';
import Sighting from './Sighting';
import SightingWindow from './SightingWindow';
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
                    <SightingWindow lat={selected.lat} lng={selected.lng} time={selected.time} />
                </InfoWindow>) : null}
            </GoogleMap>
        </div>
    );
}

export default SightingsMap;
