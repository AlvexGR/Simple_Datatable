import React from "react";
import "./App.css";
import DataTable from "./components/Datatable";
import UserService from "./services/userService";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.goToPage = this.goToPage.bind(this);
  }

  userService = new UserService();
  state = {
    currentPage: undefined,
    firstPage: undefined,
    lastPage: undefined,
    nextPage: undefined,
    prevPage: undefined,
    totalPages: undefined,
    users: []
  };

  async componentDidMount() {
    await this.goToPage(1);
  }

  async goToPage(page) {
    if (!page) {
      return;
    }
    const data = await this.userService.getAll(page);
    this.setState({
      currentPage: data.currentPage,
      firstPage: data.firstPage,
      lastPage: data.lastPage,
      nextPage: data.nextPage,
      prevPage: data.prevPage,
      totalPages: data.totalPages,
      users: data.users
    });
  }

  render() {
    console.log(this.state);
    return (
      <div className="App">
        <DataTable data={this.state} goToPage={this.goToPage} />
      </div>
    );
  }
}

export default App;
