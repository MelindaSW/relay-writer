import React from 'react'
import TableContainer from '@material-ui/core/TableContainer'
import TableBody from '@material-ui/core/TableBody'
import TableHeader from './TableHeader'
import TableRows from './TableRows'
import './table.scss'

const Table = props => {
  const { headerData, rowData } = props

  return (
    <>
      <TableContainer>
        <TableHeader headerData={headerData} />
        <TableBody>
          <TableRows rowData={rowData} />
        </TableBody>
      </TableContainer>
    </>
  )
}

export default Table
