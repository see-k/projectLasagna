import './../App.css';
import {useState, useEffect} from 'react';

function Sighting( sightingId, imgPath, visualDescription, sightingDescription, sightingDate, sightingTime, disabled, usersId, locationId, catId ) {
   /*const defaultSighting = {
        sightingId: 0,
        imgPath: null,
        visualDescription: "N/A",
        sightingDescription: "N/A",
        sightingDate: null,
        sightingTime: null,
        disabled: false,
        usersId: 0,
        locationId: 0,
        catId: 0
    }*/

    const defaultCat = {
        catId: 0,
        catName: "N/A",
        imgPath: null,
        catDescription: "N/A",
        disabled: false,
        usersId: 0
    }

    //const[sighting, setSighting] = useState(defaultSighting);

    const[cat, setCat] = useState(defaultCat);

    /*const getSighting = (sightingId) => {
        fetch(`http://localhost:8080/api/cat/${sightingId}`)
        .then((response) => {
            if (response.status !== 200) {
                console.log(response);
                return Promise.reject("get didn't work...");
                }
                return response.json();
        }).then((json) => {
            setSighting([sighting, json]);});

    }*/

    //conditional rendering get cat if catId not 0
    const getCat = (catId) => {
        fetch(`http://localhost:8080/api/cat/${catId}`)
        .then((response) => {
            if (response.status !== 200) {
                console.log(response);
                return Promise.reject("get didn't work...");
                }
                return response.json();   
        })
        .then((json) => setCat(json))
        .catch(console.log());
    }

    //render update and delete if admin
  return (
    <>
        <h1>Sighting</h1>
        <div className="card">
            <div className="row">
                <div className="col">
                    {/*image here*/}
                </div>
                <div className="col">
                    <li className="list-group-item">
                        Sighting {sightingId}
                    </li>
                    <li className="list-group-item">
                        Description: {sightingDescription}
                    </li>
                </div>
            </div>
            <div className="row">
                <div className="col">
                    Date: {sightingDate}
                </div>
                <div className="col">
                    Time: {sightingTime}
                </div>
            </div>
        </div>
    </>
  );
}

export default Sighting;
