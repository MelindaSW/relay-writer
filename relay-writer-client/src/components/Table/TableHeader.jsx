import React from 'react'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import './table.scss'

const TableHeader = props => {
  const { headerData } = props
  return (
    <TableHead>
      <TableRow>
        {headerData.map(data => (
          <TableCell>{data}</TableCell>
        ))}
      </TableRow>
    </TableHead>
  )
}

export default TableHeader
