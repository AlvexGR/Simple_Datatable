import React from "react";
import "./App.css";
import DataTable from "./components/Datatable";

class App extends React.Component {
  state = {
    users: []
  };

  componentDidMount() {
    fetch("http://localhost:1503/simple_datatable/api/test")
      .then(results => results.json())
      .then(data => {
        this.setState({
          users: data
        })
      });
  }

  render() {
    return (
      <div className="App">
        <DataTable users={this.state.users}></DataTable>
      </div>
    );
  }
}

export default App;
