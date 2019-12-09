import React, { Component } from "react";
class SearchBox extends Component {
  state = {
    isSimple: true,
    switchSearchText: "Advanced search",
    showSimple: true
  };

  constructor(props) {
    super(props);
    this.switchSearch = this.switchSearch.bind(this);
  }

  switchSearch() {
    this.setState({
      isSimple: !this.state.isSimple,
      switchSearchText: this.state.isSimple
        ? "Simple search"
        : "Advanced search",
      showSimple: !this.state.showSimple
    });
  }

  render() {
    return (
      <div id="accordion">
        <div className="card">
          <div className="card-header" id="headingOne">
            {this.state.showSimple ? (
              <div
                className="input-group input-group-sm hidden-xs float-left"
                style={{ width: "200px" }}
              >
                <input
                  type="text"
                  name="table_search"
                  className="form-control pull-right"
                  placeholder="Search"
                />
                <div className="input-group-btn">
                  <button type="submit" className="btn btn-outline-success">
                    <i className="fa fa-search"></i>
                  </button>
                </div>
              </div>
            ) : null}
            <button
              id="searchSwitchButton"
              className="btn btn-link float-right"
              data-toggle="collapse"
              data-target="#collapseOne"
              aria-expanded="true"
              aria-controls="collapseOne"
              onClick={this.switchSearch}
            >
              {this.state.switchSearchText}
            </button>
          </div>

          <div
            id="collapseOne"
            className="collapse"
            aria-labelledby="headingOne"
            data-parent="#accordion"
          >
            <div className="card-body">
              <div className="row mb-3">
                <div className="col-sm-4">
                  <div class="form-group">
                    <label>Id:</label>
                    <input type="text" className="form-control" />
                  </div>
                </div>
                <div className="col-sm-4">
                  <div class="form-group">
                    <label>Phone number:</label>
                    <input type="text" className="form-control" />
                  </div>
                </div>
                <div className="col-sm-4">
                  <div class="form-group">
                    <label>Name:</label>
                    <input type="text" className="form-control" />
                  </div>
                </div>
              </div>
              <div className="row">
                <div className="col-sm-4"></div>
                <div className="col-sm-4">
                  <button className="btn btn-primary btn-block">Search</button>
                </div>
                <div className="col-sm-4"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default SearchBox;
