import React, {Component} from "react"
import MissionDetailsComp from './MissionDetailsComp';
import TheForceUnleashedComp from './TheForceUnleashedComp'
import {Button, ButtonToolbar} from 'react-bootstrap';

/**
 * This component should show some information about a Star Wars character.
 * @returns {*}
 * @constructor
 */
class StartingScreen extends Component {

    constructor(props) {
        super(props);
        this.handleMissionDetailsView = this.handleMissionDetailsView.bind(this);
        this.handleForceUnleashedView = this.handleForceUnleashedView.bind(this);
        this.state = {
            isStartingScreen: true,
            isMissionDetailsScreen: false,
            isForceUnleashedScreen: false,
            description: []
        };
    }

    handleMissionDetailsView() {
        this.setState({isMissionDetailsScreen: true, isStartingScreen: false});
    }

    handleForceUnleashedView() {
        this.setState({isForceUnleashedScreen: true, isStartingScreen: false});
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/v1/sw/character/introduction")
            .then(result => result.json())
            .then(json => this.setState({description: json.results}))
    }

    render() {
        const isStartingScreen = this.state.isStartingScreen;
        const isMissionDetailsScreen = this.state.isMissionDetailsScreen;
        const isForceUnleashedScreen = this.state.isForceUnleashedScreen;
        if (isStartingScreen) {

            return (
                <div>
                    <div>
                    {this.state.description}
                    </div>
                    <div className="buttonContainer">
                        <ButtonToolbar className="buttonToolbar">
                            <Button variant="danger" onClick={this.handleMissionDetailsView}>Mission Details</Button>

                            <Button variant="waring" onClick={this.handleForceUnleashedView}>The Force
                                Unleashed</Button>
                        </ButtonToolbar>
                    </div>
                </div>
            )
        }

        if (isMissionDetailsScreen) {
            return <MissionDetailsComp/>
        }

        if (isForceUnleashedScreen) {
            return <TheForceUnleashedComp/>
        }
    }
}

export default StartingScreen
