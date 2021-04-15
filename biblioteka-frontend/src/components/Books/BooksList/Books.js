import React from 'react'
import Book from '../Book/Book'
import ReactPaginate from 'react-paginate'
import {Link} from 'react-router-dom'

class Books extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                
                <div className="row">
                <h3>Available books:</h3>
                    {books}
                    <div className="col mb-3">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/book/add"}>Add new product</Link>
                            </div>
                    </div>
                </div>
                <div className="row">
                    <ReactPaginate previousLabel={"Back"}
                                nextLabel={"Next"}
                                breakLabel={<a href="/#">...</a>}
                                breakClassName={"break-me"}
                                pageClassName={"ml-1"}
                                pageCount={pageCount}
                                marginPagesDisplayed={2}
                                pageRangeDisplayed={5}
                                onPageChange={this.handlePageClick}
                                containerClassName={"pagination m-4 justify-content-center"}
                                activeClassName={"active"}/>
                </div>

                
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset,nextPageOffset) => {
            return this.props.books.map((term) => {
                return (
                    <Book key={term.id} book={term} markAsTaken={this.props.markAsTaken} onDelete={this.props.onDelete} onEdit={this.props.onEdit} />
                )
            }).filter((book, index) => {
                return index >= offset && index < nextPageOffset;
            })
    }
}


export default Books;