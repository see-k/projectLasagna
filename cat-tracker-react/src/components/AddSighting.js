//import './../App.css';
import {useState, useEffect, useHistory, useParams} from 'react';
import Path from 'path';
import uploadFileToBlob, { isStorageConfigured } from './azure-storage-blob';

const storageConfigured = isStorageConfigured();

function AddSighting({latitude, longitude, time, addSighting, cancel}) {

  // all blobs in container
  const [blobList, setBlobList] = useState([]);

  // current file to upload into container
  const [fileSelected, setFileSelected] = useState(null);

  // UI/form management
  const [uploading, setUploading] = useState(false);
  const [inputKey, setInputKey] = useState(Math.random().toString(36));

  const onFileChange = (event) => {
    // capture file into state
    setFileSelected(event.target.files[0]);
  };

  const onFileUpload = async () => {
    // prepare UI
    setUploading(true);

    // *** UPLOAD TO AZURE STORAGE ***
    const blobsInContainer = await uploadFileToBlob(fileSelected);

    // prepare UI for results
    setBlobList(blobsInContainer);

    // reset state/form
    setFileSelected(null);
    setUploading(false);
    setInputKey(Math.random().toString(36));
  };

    // display form
    const DisplayForm = () => (
      <div>
        <input type="file" onChange={onFileChange} key={inputKey || ''} />
        <button type="submit" onClick={onFileUpload}>
          Upload!
            </button>
      </div>
    )
  
    // display file name and image
    const DisplayImagesFromContainer = () => (
      <div>
        <h2>Container items</h2>
        <ul>
          {blobList.map((item) => {
            return (
              <li key={item}>
                <div>
                  {Path.basename(item)}
                  <br />
                  <img src={item} alt={item} height="200" />
                </div>
              </li>
            );
          })}
        </ul>
      </div>
    );
  



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
      const [usersId, setUsersId] = useState(1);
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
              
            <div>
              <h1>Upload a picture</h1>
              {storageConfigured && !uploading && DisplayForm()}
              {storageConfigured && uploading && <div>Uploading</div>}
              <hr />
              {storageConfigured && blobList.length > 0 && DisplayImagesFromContainer()}
              {!storageConfigured && <div>Storage is not configured.</div>}
            </div>



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
