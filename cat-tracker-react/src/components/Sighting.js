import './../App.css';
import {useState, useEffect} from 'react';
import {BrowserRouter as Link} from 'react-router-dom';
import { Modal } from 'react-bootstrap';

function Sighting({ sightingId, picture, catDescription, sightingDescription, sightingDate, sightingTime, latitude, longitude, disabled, usersId, catId, removeSighting }) {
   /*const defaultSighting = {
        sightingId: 0,
        imgPath: null,
        visualDescription: "N/A",
        sightingDescription: "N/A",
        sightingDate: null,
        sightingTime: null,
        latitude: 0,
        longitude: 0,
        disabled: false,
        usersId: 0,
        catId: 0
    }*/

    const deleteById = () => {
        fetch(`http://localhost:8080/api/sighting/${sightingId}`, {method: "DELETE" })
            .then (response => {
                if (response.status === 204 || response.status === 404) {
                removeSighting(sightingId);
            } else {
                return Promise.reject(`delete found with status ${response.status}`)
            }
        });
    }

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

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    
    //render update and delete if admin
  return (
      <>
        <Modal
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}
            size="sm"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Body><h3>Confirm Delete?</h3></Modal.Body>
            <Modal.Footer>
            <button className="btn btn-secondary" onClick={handleClose}>
                Cancel
            </button>
            <button className="btn btn-warning" onClick={deleteById}>
                Delete
          </button>
            </Modal.Footer>
        </Modal>
        <div className="card" style={{width: '30rem'}}>
            <div className="row">
                <div className="col">
                    {/*image here*/}
                </div>
                <div className="col">
                    <li className="list-group-item">
                        Sighting {sightingId}
                    </li>
                    { (catId > 1) ?
                    (<li className="list-group-item">
                        Cat: {cat.catName}
                    </li>): null}
                    <li className="list-group-item">
                        Description: {sightingDescription}
                    </li>
                </div>
            </div>
            <div className="row">
                <div className="col">
                    Date: {sightingDate}, {sightingTime}
                </div>
                <div className="col">
                    Location: {latitude}, {longitude}
                </div>
            </div>
            <div className="row">
                <div className="col">
                    <Link className="btn btn-warning ml-2" to={`/sightings/edit/${sightingId}`}>Update</Link>
                </div>
                <div className="col">
                    <button className="btn btn-secondary" onClick={handleShow}>Delete</button> 
                </div>
            </div>
        </div>
       </> 
  );
}

export default Sighting;
