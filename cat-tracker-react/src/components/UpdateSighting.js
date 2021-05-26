import { useEffect, useState } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';

function UpdateSighting() {
    const defaultSighting = {
        sightingId: 0,
        imgPath: null,
        visualDescription: "N/A",
        sightingDescription: "N/A",
        sightingDate: time,
        sightingTime: new Date().toLocaleTimeString('it-IT'),
        latitude: latitude,
        longitude: longitude,
        disabled: false,
        usersId: 0,
        catId: 0
    }

    const [sighting, setSighting] = useState(defaultSighting);

    const { id } = useParams();
    const history = useHistory();

    useEffect(() => {
        fetch(`http://localhost:8080/api/sighting/${id}`)
        .then(response => response.json())
        .then(data => setSighting(data))
        .catch(error => console.log(error))
      }, [id]);

      const [picture, setPicture] = useState("");
      const [visualDescription, setVisualDescription] = useState("");
      const [sightingDescription, setSightingDescription] = useState("");
      const [sightingDate, setSightingDate] = useState(time);
      const [sightingLatitude, setSightingLatitude] = useState(latitude);
      const [sightingLongitude, setSightingLongitude] = useState(longitude);
      const [disabled, setDisabled] = useState(false);
      const [usersId, setUsersId] = useState(0);
      const [catId, setCatId] = useState(0);

    
      const handleUpdate = (event) => {
            event.preventDefault();

            const newSighting = {
                sightingId: sighting.sightingId,
                picture = picture, //CHIKE
                visualDescription = visualDescription,
                sightingDescription = sightingDescription,
                sightingDate = sightingDate,
                sightingTime = sightingTime,
                latitude = latitude,
                longitude = longitude,
                disabled = disabled,
                usersId = usersId, //DERRICK
                catId = 2, 
            };

            const init = {
                method: "PUT",
                headers: {
                  "Content-Type": "application/json",
                  Accept: "application/json",
                },
                body: JSON.stringify(newSighting),
              };
              
            fetch(`http://localhost:8080/api/sighting/${sighting.sightingId}`, init)
            .then((response) => {
            if (response.status !== 204) {
                return Promise.reject("update failed");
            }
            })
            .then(history.push('/'))
            .catch(console.log);
    
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
                    {cats.map(cat => <option value={cat.catId}>{cat.catId}: {cat.name}</option> )}
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

export default UpdateSighting;
