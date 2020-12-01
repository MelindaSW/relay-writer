import React from 'react'
import { connect } from 'react-redux'
import './newStory.scss'

const NewStory = props => {
  return (
    <div>
      {' '}
      <h1>New story</h1>
      <p>{props.newStoryState.title}</p>
    </div>
  )
}
const mapStateToProps = ({ newStoryState }) => {
  return { newStoryState }
}

export default connect(mapStateToProps)(NewStory)

// const mapStateToProps = ({
//   topPanelState: { settings },
//   settingsState: { tabSettings },
//   logViewerState: {
//     logs,
//     lengthOfInitialLogLineArrays,
//     totalNrOfLinesForFiles,
//     lengthOfEmptyLines,
//     currentScrollTops,
//     indexesForNewLines,
//     filteredLogs,
//     totalNrOfFilteredLines,
//     filterString
//   },
//   logInfoState: { logSizes, lastSeenLogSizes }
// }) => {
//   return {
//     settings,
//     tabSettings,
//     logs,
//     logSizes,
//     lastSeenLogSizes,
//     lengthOfInitialLogLineArrays,
//     totalNrOfLinesForFiles,
//     lengthOfEmptyLines,
//     currentScrollTops,
//     indexesForNewLines,
//     filteredLogs,
//     totalNrOfFilteredLines,
//     filterString
//   }
// }

// export default connect(mapStateToProps)(LogViewer)
