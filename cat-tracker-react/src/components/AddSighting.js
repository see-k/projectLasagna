//import './../App.css';
import {useState, useEffect, useHistory, useParams} from 'react';

function AddSighting({latitude, longitude, time}) {
    // const defaultSighting = {
    //     sightingId: 0,
    //     imgPath: null,
    //     visualDescription: "N/A",
    //     sightingDescription: "N/A",
    //     sightingDate: time,
    //     sightingTime: new Date().toLocaleTimeString('it-IT'),
    //     latitude: latitude,
    //     longitude: longitude,
    //     disabled: false,
    //     usersId: 0,
    //     catId: 0
    // }

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
      const [sightingDate, setSightingDate] = useState(time);
      const [sightingLatitude, setSightingLatitude] = useState(latitude);
      const [sightingLongitude, setSightingLongitude] = useState(longitude);
      const [disabled, setDisabled] = useState(false);
      const [usersId, setUsersId] = useState(0);
      const [catId, setCatId] = useState(0);

      //const [sighting, setSighting] = useState(defaultSighting);
    
      const [sightings, setSightings] = useState([]);
      const [messages, setMessages] = useState("");
    
      useEffect(() => {
        fetch("http://localhost:8080/api/sighting")
          .then((response) => {
            if (response.status !== 200) {
              console.log(response);
              return Promise.reject("sighting get error");
            }
            return response.json();
          })
          .then((json) => setSightings(json))
          .catch(console.log);
      }, []);
    
      const addFetch = (sighting) => {
        const init = {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
          body: JSON.stringify(sighting),
        };
    
        fetch("http://localhost:8080/api/sighting", init)
          .then((response) => {
            if (response.status !== 201) {
              return Promise.reject("Error.");
            }
            return response.json();
          })
          .then((json) => {
            setSightings([...sightings, json]);
            setMessages("");
          })
          .catch(console.log);
      };
    
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
    
      const handleAdd = (event) => {
        event.preventDefault();
        event.stopPropagation();
    
        let sighting = {};
    
        sighting["picture"] = picture; //CHIKE
        sighting["visualDescription"] = visualDescription;
        sighting["sightingDescription"] = sightingDescription;
        sighting["sightingDate"] = time;
        sighting["sightingTime"] = new Date().toLocaleTimeString('it-IT');
        sighting["latitude"] = latitude;
        sighting["longitude"] = longitude;
        sighting["disabled"] = disabled;
        sighting["usersId"] = usersId; //DERRICK
        sighting["catId"] = catId;
    
        addSighting(sighting);
      };
    
      const handleVDChange = (event) => {
        setVisualDescription(event.target.value);
      };
    
      const handleSDChange = (event) => {
        setSightingDescription(event.target.value);
      };
    
      const handleCatChange = (event) => {
        setLastName(event.target.value);
      };
    
      const handleDOBChange = (event) => {
        setDob(event.target.value);
      };
    
      const handleHeightChange = (event) => {
        setHeight(event.target.value);
      };
    return (
        <div className="card">
        <h2 className="card-title ml-3">Add Agent</h2>
        <div className="card-body">
            <form onSubmit={handleAdd}>
            {/* CHIKE upload picture div here */}
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
            <div className="form-group">
                <label htmlFor="DOB">Date of Birth:</label>
                <select id="chooseCat" onChange={handleCatChange} className="form-control">
                    {cats.map(cat => <option value="grapefruit">{cat.name}</option> )}
                </select>
            </div>
            <div className="form-group">
                <label htmlFor="height">Height (inches):</label>
                <input
                type="number"
                id="HeightBox"
                onChange={handleHeightChange}
                className="form-control"
                placeholder="I'm required"
                required
                />
            </div>
            <button type="submit" className="btn btn-primary mt-2">
                Add
            </button>
            </form>
        </div>
        </div>
    );
}

export default AddSighting;
