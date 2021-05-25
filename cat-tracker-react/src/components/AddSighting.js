//import './../App.css';
import {useState, useHistory, useParams} from 'react';

function AddSighting({latitude, longitude, time}) {
    const defaultSighting = {
        sightingId: 0,
        imgPath: null,
        visualDescription: "N/A",
        sightingDescription: "N/A",
        sightingDate: new Date("12-12-2000"),
        sightingTime: new Date().toLocaleTimeString('it-IT'),
        latitude: 0,
        longitude: 0,
        disabled: false,
        usersId: 0,
        catId: 0
    }
    
    //   const [picture, setPicture] = useState("");
    //   const [visualDescription, setVisualDescription] = useState("");
    //   const [sightingDescription, setSightingDescription] = useState("");
    //   const [sightingDate, setSightingDate] = useState();
    //   const [latitude, setLatitude] = useState();
    
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
    
        agent["firstName"] = firstName;
        agent["middleName"] = middleName;
        agent["lastName"] = lastName;
        agent["dob"] = dob;
        agent["heightInInches"] = height;
        agent["agencies"] = [];
    
        addAgent(agent);
      };
    
      const handleFNChange = (event) => {
        setFirstName(event.target.value);
      };
    
      const handleMNChange = (event) => {
        setMiddleName(event.target.value);
      };
    
      const handleLNChange = (event) => {
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
            <div className="form-group">
                <label htmlFor="firstNameTextBox">First Name:</label>
                <input
                type="text"
                id="firstNameTextBox"
                onChange={handleFNChange}
                className="form-control"
                placeholder="I'm required"
                required
                />
            </div>
            <div className="form-group">
                <label htmlFor="middleNameTextBox">Middle Name:</label>
                <input
                type="text"
                id="middleNameTextBox"
                onChange={handleMNChange}
                className="form-control"
                />
            </div>
            <div className="form-group">
                <label htmlFor="firstLastTextBox">Last Name:</label>
                <input
                type="text"
                id="lastNameTextBox"
                onChange={handleLNChange}
                className="form-control"
                placeholder="I'm required"
                required
                />
            </div>
            <div className="form-group">
                <label htmlFor="DOB">Date of Birth:</label>
                <input
                type="date"
                id="DOBbox"
                onChange={handleDOBChange}
                className="form-control"
                required
                />
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
