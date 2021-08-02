import React from 'react'
import TableContainer from '@material-ui/core/TableContainer'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import Icon from '@material-ui/core/Icon'

import './table.scss'

const StoriesTable = props => {
  const { headerData, rowData } = props
  const iconColor2 = '#00818a'
  const iconColor1 = '#283149'

  return (
    <>
      <TableContainer>
        <Table>
          <TableHead>
            <TableRow key={1}>
              {headerData.map(data => (
                <TableCell>{data}</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rowData.map(d => (
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
    </>
  )
}

export default StoriesTable
