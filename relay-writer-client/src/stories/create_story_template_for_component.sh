#!/bin/bash

# Pass the name of the folder (existing or non-existing) as first argument 
# and the name of the component as the second argument

echo "Running" $0

[ -z "$2" ] && echo "ERROR: Not enough arguments. Provide: 1: Folder name, 2: Component name" && exit 1

dir=$1
name=$2

dirPath=$dir/

storyFile=./$dirPath/$name.stories.jsx

[ -d $dirPath ] && echo ""$dirPath" already exists. Adding story to existing directory"
[ -f $storyFile ] && echo ""$storyFile" already exists. Aborting script." && exit 1

mkdir -p -v $dirPath
touch $storyFile

echo "Creating story for "$name""

echo "import React from 'react';
import { "$name" } from '../../"$dir"';

export default {
  title: '"$dir"/"$name"',
  component: "$name",
  argTypes: {}
}

const Template = args => <"$name" {...args} />

export const Primary = Template.bind({})
Primary.args = {};" >> $storyFile


echo "Added content to the "$name" story"
echo "Story created"
echo