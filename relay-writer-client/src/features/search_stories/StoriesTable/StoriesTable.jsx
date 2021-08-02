import React from 'react'
import TableContainer from '@material-ui/core/TableContainer'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import TablePagination from '@material-ui/core/TablePagination'
import Paper from '@material-ui/core/Paper'
import Icon from '@material-ui/core/Icon'
import { makeStyles } from '@material-ui/core/styles'
import './table.scss'

const useStyles = makeStyles({
  root: {
    width: '100%'
  },
  container: {
    maxHeight: 700
  }
})

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
    <Paper className={classes.root}>
      <TableContainer className={classes.container}>
        <Table>
          <TableHead>
            <TableRow key={1}>
              {headerData.map(data => (
                <TableCell>{data}</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rowData
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map(d => (
                <TableRow key={d.id}>
                  <TableCell>{d.title}</TableCell>
                  <TableCell>{d.creator.userName}</TableCell>
                  <TableCell>{d.creator.createdAt.slice(0, 10)}</TableCell>
                  <TableCell align="right">
                    {d.finished ? (
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
                    {d.finished ? (
                      <Icon style={{ color: iconColor1 }} fontSize="small">
                        auto_stories
                      </Icon>
                    ) : (
                      <Icon style={{ color: iconColor2 }} fontSize="small">
                        edit
                      </Icon>
                    )}
                  </TableCell>
                  <TableCell align="right">
                    <span>
                      <Icon
                        id="expand-row"
                        style={{ color: '#283149' }}
                        fontSize="small"
                      >
                        expand_more
                      </Icon>
                    </span>
                  </TableCell>
                </TableRow>
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
    </Paper>
  )
}

export default StoriesTable
