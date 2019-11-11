import React, {useEffect, useState} from "react"
import axios from 'axios';
import {Button} from 'react-bootstrap';
import {ButtonToolbar} from 'react-bootstrap';
import MissionDetailsComp from './MissionDetailsComp';
import TheForceUnleashedComp from './TheForceUnleashedComp'

/**
 * This component should show some information about a Star Wars character.
 * @returns {*}
 * @constructor
 */
const MyComponent = () => {
    const [name, setName] = useState("Luke");
    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/sw/character/introduction')
            .then(res => {
                setName(res.data);
            });
        setName("Luke")
    }, []);

    function getMissionDetailsView() {
        MissionDetailsComp.renderTheView();
    }

    function getForceUnleashedView() {
        TheForceUnleashedComp.renderTheView();
    }

    return <div>
        Character: {name}

        <div className="buttonContainer">
            <ButtonToolbar>
                <Button variant="danger" onClick={ getMissionDetailsView  }>Mission Details</Button>

                <Button variant="waring" onClick={ getForceUnleashedView }>The Force Unleashed</Button>
            </ButtonToolbar>
        </div>
    </div>
};

export default MyComponent
