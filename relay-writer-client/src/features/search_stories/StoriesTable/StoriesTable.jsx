import React from 'react'
import TableContainer from '@material-ui/core/TableContainer'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import TablePagination from '@material-ui/core/TablePagination'
import Icon from '@material-ui/core/Icon'
import { makeStyles, withStyles } from '@material-ui/core/styles'
import './table.scss'

const useStyles = makeStyles({
  root: {
    width: '100%'
  },
  container: {
    maxHeight: 700
  }
})

const StyledTableRow = withStyles(theme => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover
    }
  }
}))(TableRow)

const StoriesTable = props => {
  const { headerData, rowData } = props
  const iconColor2 = '#00818a'
  const iconColor1 = '#283149'

  const [page, setPage] = React.useState(0)
  const [rowsPerPage, setRowsPerPage] = React.useState(10)

  const classes = useStyles()

  const handleChangePage = (event, newPage) => {
    setPage(newPage)
  }

  const handleChangeRowsPerPage = event => {
    setRowsPerPage(+event.target.value)
    setPage(0)
  }

  return (
    <>
      <TableContainer className={classes.container}>
        <Table stickyHeader>
          <TableHead>
            <TableRow key={headerData[0]}>
              {headerData.map(data => (
                <TableCell key={data}>{data}</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rowData
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map(data => (
                <StyledTableRow key={data.id}>
                  <TableCell>{data.title}</TableCell>
                  <TableCell>{data.creator.userName}</TableCell>
                  <TableCell>
                    {data.creator.createdAt.replace('T', ' ').slice(0, 16)}
                  </TableCell>
                  <TableCell align="right">
                    {data.finished ? (
                      <Icon style={{ color: iconColor1 }} fontSize="small">
                        checked
                      </Icon>
                    ) : (
                      <Icon style={{ color: iconColor2 }} fontSize="small">
                        more_horiz
                      </Icon>
                    )}
                  </TableCell>
                  <TableCell align="right">
                    {data.finished ? (
                      <Icon
                        id="read-icon"
                        style={{ color: iconColor1 }}
                        fontSize="small"
                      >
                        auto_stories
                      </Icon>
                    ) : (
                      <Icon
                        id="edit-icon"
                        style={{ color: iconColor2 }}
                        fontSize="small"
                      >
                        edit
                      </Icon>
                    )}
                  </TableCell>
                  <TableCell align="right">
                    <span>
                      <Icon
                        id="expand-row"
                        style={{ color: '#283149' }}
                        fontSize="medium"
                      >
                        expand_more
                      </Icon>
                    </span>
                  </TableCell>
                </StyledTableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
      <TablePagination
        rowsPerPageOptions={[10, 25, 50, 100, 200]}
        component="div"
        count={rowData.length}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </>
  )
}

export default StoriesTable
