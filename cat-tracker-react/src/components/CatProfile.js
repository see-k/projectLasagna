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
        usersId: 0,
        aliases: []
    }
    const [catNum, setCatNum] = useState(0);
    const[cat, setCat] = useState(defaultCat);

    const handleSetCatId = (event) => {
        setCatNum(event.target.value);
    }

    //conditional rendering get cat if catId not 0
    const getCat = (event) => {
        event.preventDefault();
        event.stopPropagation();

        fetch(`http://localhost:8080/api/cat/${catNum}`)
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
            <div className="card-body">
                <form onSubmit={getCat}>
                    <div className="form-group">
                        <label>Search Cat Id</label>
                        <input type="number" min="1" max="100" className="form-control" onChange={handleSetCatId} />
                        <br></br>
                        <button type="submit" className="btn btn-outline-primary">Find Cat</button>

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
                    <li className="list-group-item">Name: {cat.name}</li>
                    <li className="list-group-item">Id: {cat.catId}</li>
                    <li className="list-group-item">Description: {cat.desc}</li>
                    <li className="list-group-item">Aliases: 
                        {cat.aliases.map(a => <p>{a}</p>)}
                    </li>
                    <li className="list-group-item"></li>
                    
                        
                    <br></br>
                        
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