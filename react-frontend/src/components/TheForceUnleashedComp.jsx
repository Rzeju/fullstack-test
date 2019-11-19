import React, {Component} from 'react'
import ReactDOM from 'react-dom';


class TheForceUnleashedComp extends Component {

    constructor(props) {
        super(props);
        this.renderTheView = this.renderTheView.bind(this);
        this.state = {name: '', secondName: ''}
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({name: event.target.name})
        this.setState({secondName: event.target.secondName})
    }

    handleSubmit(event) {
        alert('Your name and secondName are: ' + event.target.name + " " + event.target.secondName)
        event.preventDefault();
    }

    renderTheView() {
        return ReactDOM.render(this.render(), document.getElementById('root'));
    }

    render() {
        return (
            <div className="container">
                <h1>The Force Unleashed</h1>
                <div className="formContainer">
                    <form onSubmit={this.handleSubmit}>
                        <label>
                            Name:
                            <input type="text" name="name" value={this.state.name}
                                   onChange={this.handleChange}/>
                        </label>
                        <label>
                            Second name:
                            <input type="text" name="secondName" value={this.state.secondName}
                                   onChange={this.handleChange}/>
                        </label>
                        <input type="submit" value="Get Power" />
                    </form>
                </div>
            </div>
        )
    }
}

export default TheForceUnleashedComp
