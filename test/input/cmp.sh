#!/bin/bash
file1="$1"".""$2"
file2="../$2-ref/$1.$2"
#echo "$(cat $file1)"
#echo "$(cat $file2)"

DIFF=$(diff -w $file1 $file2) 
if [ "$DIFF" != "" ] ;
then
    echo "$1.$2 don't match"

fi