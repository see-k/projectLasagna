import './../App.css';
import {useState, useEffect} from 'react';
import { createFactory } from 'react';
import Path from 'path';
import uploadFileToBlob, { isStorageConfigured } from './azure-storage-blob';

function CatProfile() {

    const defaultCat = {
        catId: 0,
        catName: "N/A",
        imgPath: null,
        catDescription: "N/A",
        disabled: false,
        usersId: 0
    }
    const [catNum, setCatNum] = useState(0);
    const[cat, setCat] = useState(defaultCat);

    const handleSetCatId = (event) => {
        setCatNum(event.target.value);
    }

    //conditional rendering get cat if catId not 0
    const getCat = async (event) => {
        event.preventDefault();
        event.stopPropagation();

        await fetch(`http://localhost:8080/api/cat/${catNum}`)
        .then((response) => {
            if (response.status !== 200) {
                console.log(response);
                return Promise.reject("get didn't work...");
                }
                return response.json();   
        })
        .then((json) => {setCat(json)})
        .catch(console.log());
    }

    const deleteCat = async (event) => {
        event.preventDefault();
        event.stopPropagation();

        await fetch(`http://localhost:8080/api/cat/${catNum}`, {method: "DELETE" })
        .then((response) => {
            if (response.status !== 200) {
                console.log(response);
                return Promise.reject("get didn't work...");
                }
                return response.json();   
        })
        .catch(console.log());
    }

    return (
        <div className="card">
            <div>
                <form onSubmit={getCat}>
                    <div className="form-group">
                        <label>Enter the users id</label>
                        <input type="text" className="form-control" onChange={handleSetCatId} />
                        <br></br>
                        <button type="submit" className="btn btn-outline-primary">find this cat</button>

                    </div>
                </form>
            </div>
            <br></br>
            <br></br>
            <div className="row">
                <div className="col">
                <img src={`https://cattracker.blob.core.windows.net/tutorial-container/${cat.picture}`} alt={`https://cattracker.blob.core.windows.net/tutorial-container/${cat.picture}`} height="200" />
                    </div>
                <div className="col">
                    Name: {cat.name}
                    <br></br>
                        Id: {cat.catId}
                    <br></br>
                        Description: {cat.desc}
                    <br></br>
                        Image path: {cat.picture}
                    <br></br>
                    <br></br>
                    <button type="text" className="btn btn-outline-danger" onClick={deleteCat}>Delete</button>
                </div>

            </div>
        </div>
    );
}

export default CatProfile;