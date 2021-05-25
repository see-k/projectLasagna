import './../App.css';
import {useState, useEffect} from 'react';

function CatProfile() {

    const defaultCat = {
        catId: 0,
        catName: "N/A",
        imgPath: null,
        catDescription: "N/A",
        disabled: false,
        usersId: 0
    }

    const[cat, setCat] = useState(defaultCat);

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

    return (
        <div className="card">
                <div className="row">
                    <div className="col">
                        {/*image here*/}
                    </div>
                    <div className="col">
                        <li className="list-group-item">
                            {/*Sighting {sightingId}*/}
                        </li>
                        <li className="list-group-item">
                            {/*Description: {sightingDescription}*/}
                        </li>
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        {/*Date: {sightingDate}, {sightingTime}*/}
                    </div>
                    <div className="col">
                        {/*Location: {latitude}, {longitude}*/}
                    </div>
                </div>
            </div>
    );
}

export default CatProfile;
