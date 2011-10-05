require 'rubygems'
require 'sass'

sass_engine = Sass::Engine.new(input)
output = sass_engine.render
