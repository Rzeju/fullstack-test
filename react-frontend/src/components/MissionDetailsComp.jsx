import React, {Component} from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';
import vader from "./vader.webp";


class MissionDetailsComp extends Component {

    constructor(props) {
        super(props);
        this.renderTheView = this.renderTheView.bind(this);
    }

    state = {
        description: ''
    };

    componentDidMount() {
        fetch("http://localhost:8080/api/v1/sw/character/introduction")
            .then(result => {
                return result.json();
            }).then(data => {
                let description = data.result.map[(disc) => {
                    return (
                        <div>
                            disc.result
                        </div>
                    )
            }]
        this.setState({description: description})
        })

    }

    renderTheView() {
        ReactDOM.render(this.render(), document.getElementById('root'));
    }

    render() {
        return (
            <div className="container">
                <h1>MISSION DETAILS</h1>

                {this.state.description}


                <br/>

                <img src={vader} className="Vader" alt="EmpireLogo"/>

            </div>
        )
    }
}

export default MissionDetailsComp