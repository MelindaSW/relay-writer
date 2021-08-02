import React from 'react'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import Icon from '@material-ui/core/Icon'
import './table.scss'

const TableRows = props => {
  const { rowData } = props
  return (
    <>
      {rowData.map(d => (
        <>
          <TableRow key={d.id}>
            <TableCell>{d.title}</TableCell>
            <TableCell>{d.creator.userName}</TableCell>
            <TableCell>{d.creator.createdAt.slice(0, 10)}</TableCell>
            <TableCell align="right">
              {d.finished ? (
                <Icon fontSize="small">checked</Icon>
              ) : (
                <Icon fontSize="small">clear</Icon>
              )}
            </TableCell>

            <TableCell align="right">
              <Icon color={d.finished ? 'disabled' : 'action'}>edit</Icon>
            </TableCell>
            <TableCell align="right">
              <Icon>expand_more</Icon>
            </TableCell>
          </TableRow>
        </>
      ))}
    </>
  )
}

export default TableRows
