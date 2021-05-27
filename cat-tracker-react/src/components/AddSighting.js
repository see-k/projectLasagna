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
    if(fileSelected != null){
      setPicture(fileSelected.name)
    }
    
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
        <button type="submit" className="btn btn-warning" onClick={onFileUpload}>
          Upload!
            </button>
      </div>
    )
  
    // display file name and image
    const DisplayImagesFromContainer = () => (
      
      <div class="alert alert-dismissible alert-warning">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <h4 class="alert-heading">Upload Complete!</h4>
        <p class="mb-0"> Fill out the form below to add image to sighting<a href="#" class="alert-link"></a>.</p>
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
      const [sightingDate, setSightingDate] = useState(time.toISOString().substring(0,10));
      const [sightingTime, setSightingTime] = useState(time.toLocaleTimeString('it-IT'));
      // const [sightingLatitude, setSightingLatitude] = useState(latitude);
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
        sighting["sightingDate"] = sightingDate;
        sighting["sightingTime"] = sightingTime;
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

      const handleDateChange = (event) => {
          setSightingDate(event.target.value);
      }

      const handleTimeChange = (event) => {
        setSightingTime(event.target.value);
    }
    
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
            <div className="form-group">
                <label htmlFor="dateBox">Date:</label>
                <input
                    type="date"
                    id="dateBox"
                    onChange={handleDateChange}
                    className="form-control"
                    value={sightingDate}
                    min="2020-01-01" max={time.toISOString().substring(0,10)}
                    required>
                </input>
            </div>
            <div className="form-group">
                <label htmlFor="timeBox">Date:</label>
                <input
                    type="time"
                    id="timeBox"
                    onChange={handleTimeChange}
                    className="form-control"
                    value={sightingTime}
                    required>
                </input>
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