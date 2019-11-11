import React, {Component} from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';
import vader from "./vader.webp";


class MissionDetailsComp extends Component {

    constructor(props) {
        super(props)
        this.renderTheView = this.renderTheView.bind(this);
    }

    state = {
        description: ''
    };

    componentDidMount() {
        axios.get('http://localhost:8080/api/v1/sw/character/description')
            .then(res => {
                const description = res.data;
                this.setState({ description });
            })
    }

    renderTheView() {
        ReactDOM.render(this.render(), document.getElementById('root'));
    }

    render() {
        return (
            <div className="container">
                <h1>MISSION DETAILS</h1>

                <p> { this.state.description }</p>

                <p> Behold one of the darkest character in the Universe soldier. </p>

                <p> This is a Black Start of the Empire. Sith Lord, Darth Vader </p>

                <p> Previously known as lovely boy Anakin Skywalker, today he is embodied of the evil and betray </p>

                <p> Your mission won't be easy, soldier. You will risk yours and ours lifes </p>

                <p> We got one more advice for you. Do not smoke some much... </p>

                <p> Cigarettes make you to start breath like him! </p>


                <br/>

                <img src={vader} className="Vader" alt="EmpireLogo"/>

            </div>
        )
    }
}

export default new MissionDetailsComp