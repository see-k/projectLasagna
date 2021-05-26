//import './../App.css';
import {useState, useEffect, useHistory, useParams} from 'react';

function AddSighting({latitude, longitude, time, addSighting, cancel}) {
    const[cats, setCats] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/cat")
        .then((response) => {
            if (response.status !== 200) {
            console.log(response);
            return Promise.reject("cats get error");
            }
            return response.json();
        })
        .then((json) => setCats(json))
        .catch(console.log);
    }, []);
    
      const [picture, setPicture] = useState("");
      const [visualDescription, setVisualDescription] = useState("");
      const [sightingDescription, setSightingDescription] = useState("");
      //const [sightingDate, setSightingDate] = useState(time);
      //const [sightingLatitude, setSightingLatitude] = useState(latitude);
      //const [sightingLongitude, setSightingLongitude] = useState(longitude);
      const [disabled, setDisabled] = useState(false);
      const [usersId, setUsersId] = useState(0);
      const [catId, setCatId] = useState(0);

    
      const handleAdd = (event) => {
        event.preventDefault();
        event.stopPropagation();
    
        let sighting = {};
    
        sighting["picture"] = picture; //CHIKE
        sighting["visualDescription"] = visualDescription;
        sighting["sightingDescription"] = sightingDescription;
        sighting["sightingDate"] = time.toISOString().substring(0,10);
        sighting["sightingTime"] = time.toLocaleTimeString('it-IT');
        sighting["latitude"] = latitude;
        sighting["longitude"] = longitude;
        sighting["disabled"] = disabled;
        sighting["usersId"] = usersId; //DERRICK
        sighting["catId"] = 2;
    
        addSighting(sighting);
      };
    
      const handleVDChange = (event) => {
        setVisualDescription(event.target.value);
      };
    
      const handleSDChange = (event) => {
        setSightingDescription(event.target.value);
      };
    
      const handleCatChange = (event) => {
        setCatId(event.target.value);
      };
    
    return (
        <div className="card">
        <h2 className="card-title ml-3">Add Sighting</h2>
        <div className="card-body">
            <form onSubmit={handleAdd}>
            {/* CHIKE picture upload element here */}
            <div className="form-group">
                <label htmlFor="visDescTxtBox">Identifying features:</label>
                <textarea
                id="visDescTxtBox"
                onChange={handleVDChange}
                className="form-control"
                placeholder="Name tag, fur color, size, etc."
                />
            </div>
            <div className="form-group">
                <label htmlFor="sightingDescTxtBox">Description:</label>
                <textarea
                id="sightingDescTxtBox"
                onChange={handleSDChange}
                className="form-control"
                />
            </div>
            {/* render only if admin permission */}
            <div className="form-group"> 
                <label htmlFor="chooseCat">Cat:</label>
                <select id="chooseCat" onChange={handleCatChange} className="form-control">
                    {cats.map(cat => <option key={cat.catId} value={cat.catId}>{cat.catId}: {cat.name}</option> )}
                </select>
            </div>
            <button type="submit" className="btn btn-primary mt-2">
                Add
            </button>

            <button className="btn btn-primary mt-2" onClick={cancel}>Cancel</button>
            </form>
        </div>
        </div>
    );
}

export default AddSighting;
