import React from "react";
import "./App.css";
import DataTable from "./components/Datatable";

class App extends React.Component {
  state = {
    users: [
      {
        age: 23,
        id: 1,
        name: "Nguyen Ngoc Nhan"
      },
      {
        age: 23,
        id: 2,
        name: "Nguyen Ngoc Nhan"
      },
      {
        age: 23,
        id: 3,
        name: "Nguyen Ngoc Nhan"
      },
      {
        age: 23,
        id: 4,
        name: "Nguyen Ngoc Nhan"
      }
    ]
  };
  render() {
    return (
      <div className="App">
        <DataTable users={this.state.users}></DataTable>
      </div>
    );
  }
}

export default App;
