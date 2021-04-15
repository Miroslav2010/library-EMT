import React from 'react'
import './Book.css'
import {Link} from 'react-router-dom'

const Book = (props) => {
    return (
        <div className="book">
            <div className="bookInfo">
                <h3>{props.book.name}</h3>
                <h5>{props.book.author.name + ' ' + props.book.author.surname}</h5>
                <h5>{props.book.category}</h5>
            </div>
            <div className="bookControls">
                <Link to={`/book/edit/${props.book.id}`} onClick={() => props.onEdit(props.book.id)} className="btn btn-info">Edit</Link>
                <button onClick={() => {props.onDelete(props.book.id)}} className="btn btn-danger">Delete</button>
                <button onClick={() => {props.markAsTaken(props.book.id)}} className="btn btn-primary">Mark as Taken</button>
            </div>
            <div className="bookCopies">
                <h5>Available copies: {props.book.availableCopies}</h5>
            </div>
        </div>
    )
}

export default Book