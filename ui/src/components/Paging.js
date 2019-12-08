import React, { Component } from "react";

const fixedPageRange = 5;

class Paging extends Component {
  renderPagingButtons() {
    if (!this.props.totalPages) {
      return;
    }
    const buttons = [];
    if (this.props.firstPage) {
      buttons.push(
        <button
          onClick={() => this.props.goToPage(this.props.firstPage)}
          className="btn btn-light"
        >
          First
        </button>
      );
    } else {
      buttons.push(
        <button className="btn btn-light" disabled>
          First
        </button>
      );
    }
    if (this.props.prevPage) {
      buttons.push(
        <button
          onClick={() => this.props.goToPage(this.props.prevPage)}
          className="btn btn-light"
        >
          Prev
        </button>
      );
    } else {
      buttons.push(
        <button className="btn btn-light" disabled>
          Prev
        </button>
      );
    }
    let left = this.props.currentPage;
    let right = this.props.currentPage;
    let pagesToRender = fixedPageRange - 1;
    while (pagesToRender > 0) {
      if (left > this.props.firstPage) {
        left--;
        pagesToRender--;
      }
      if (right < this.props.lastPage) {
        right++;
        pagesToRender--;
      }
    }
    for (let i = left; i <= right; i++) {
      if (i === this.props.currentPage) {
        buttons.push(<button className="btn btn-primary">{i}</button>);
      } else {
        buttons.push(
          <button
            onClick={() => this.props.goToPage(i)}
            className="btn btn-light"
          >
            {i}
          </button>
        );
      }
    }
    if (this.props.nextPage) {
      buttons.push(
        <button
          onClick={() => this.props.goToPage(this.props.nextPage)}
          className="btn btn-light"
        >
          Next
        </button>
      );
    } else {
      buttons.push(
        <button className="btn btn-light" disabled>
          Next
        </button>
      );
    }
    if (this.props.lastPage) {
      buttons.push(
        <button
          onClick={() => this.props.goToPage(this.props.lastPage)}
          className="btn btn-light"
        >
          Last
        </button>
      );
    } else {
      buttons.push(
        <button className="btn btn-light" disabled>
          Last
        </button>
      );
    }

    return buttons.map((button, i) => {
      return (
        <li key={i} className="list-inline-item">
          {button}
        </li>
      );
    });
  }

  render() {
    console.log(this.props);
    return (
      <div>
        <ul className="list-inline">{this.renderPagingButtons()}</ul>
      </div>
    );
  }
}

export default Paging
