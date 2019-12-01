import React, { Component } from "react";

class DataTable extends Component {
  renderDataInTable() {
    return this.props.users.map(user => {
      return (
        <tr>
          <td>{user.id}</td>
          <td>{user.name}</td>
          <td>{user.age}</td>
        </tr>
      );
    })
  }

  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="col-md-3"></div>
          <div className="col-md-6">
            <h3 className="text-center mb-3">Simple Datatable</h3>
            <table className="table">
              <thead className="thead-dark">
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Age</th>
                </tr>
              </thead>
              <tbody>
                {this.renderDataInTable()}
              </tbody>
            </table>
          </div>
          <div className="col-md-3"></div>
        </div>
      </div>
    );
  }
}

export default DataTable;
