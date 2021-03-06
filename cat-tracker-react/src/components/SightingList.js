import Sighting from './Sighting';
import {useEffect, useState } from "react";

function SightingList() {

    const [sightings, setSightings] = useState([]);
    const [messages, setMessages] = useState("");
  

   useEffect(() => {
        fetch("http://localhost:8080/api/sighting")
        .then((response) => {
            if (response.status !== 200) {
            console.log(response);
            return Promise.reject("get didn't work...");
            }
            return response.json();
        })
        .then((json) => setSightings(json))
        .catch(console.log);
    }, []);

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

      //render update and delete if admin
    return ( 
        <div className="row">
            <div className="col">
                <div className="card">
                    <h2 className="card-title ml-3">Sightings</h2>
                    <ul className="list-group list-group-flush">
                        {sightings.map(s => <Sighting 
                            key={s.sightingId} 
                            sightingId={s.sightingId} 
                            picture={s.picture}   
                            visualDescription={s.catDescription}
                            sightingDescription={s.sightingDescription}
                            sightingDate={s.sightingDate}
                            sightingTime={s.sightingTime}
                            latitude={s.latitude}
                            longitude={s.longitude}
                            disabled={s.disabled}
                            usersId={s.usersId}
                            catId={s.catId}
                            removeSighting={removeSighting}
                            />)}
                    </ul>
                </div>
            </div>
        </div> 
    );
}

export default SightingList;