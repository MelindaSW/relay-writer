import React from 'react'
import PropTypes from 'prop-types'
import './footer.scss'

const Footer = ({ content }) => {
  return (
    <footer>
      <div id="content">{content}</div>
    </footer>
  )
}

Footer.propTypes = {
  content: PropTypes.node
}
export default Footer
