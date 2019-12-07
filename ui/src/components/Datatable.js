import React, { Component } from "react";

class DataTable extends Component {
  renderDataInTable() {
    return this.props.users.map((user, i) => {
      return (
        <tr key={i}>
          <td>{i + 1}</td>
          <td>{user.id}</td>
          <td>{user.firstName}</td>
          <td>{user.lastName}</td>
          <td>{user.email}</td>
          <td>{user.phoneNumber}</td>
          <td>{user.dateOfBirth}</td>
          <td>{user.gender ? "Male" : "Female"}</td>
          <td>{user.active ? "Active" : "Deactivated"}</td>
        </tr>
      );
    });
  }

  render() {
    return (
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h3 className="text-center mb-3 mt-3">Simple Datatable</h3>
            <table className="table table-striped table-bordered">
              <thead className="thead-dark">
                <tr>
                  <th>#</th>
                  <th>Id</th>
                  <th>First name</th>
                  <th>Last name</th>
                  <th>Email</th>
                  <th>Phone number</th>
                  <th>Date of birth</th>
                  <th>Gender</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody>{this.renderDataInTable()}</tbody>
            </table>
          </div>
          <div className="col-md-2"></div>
        </div>
      </div>
    );
  }
}

export default DataTable
