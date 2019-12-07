import React from "react";
import "./App.css";
import DataTable from "./components/Datatable";
import UserService from "./services/userService";

class App extends React.Component {
  userService = new UserService();
  state = {
    currentPage: 1,
    firstPage: 1,
    lastPage: 1,
    nextPage: 1,
    prevPage: 1,
    totalPages: 20,
    users: []
  };

  async componentDidMount() {
    const data = await this.userService.getAll(1);
    this.setState({ users: data.users });
    console.log(this.state.users);
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
