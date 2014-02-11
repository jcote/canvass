
// # Globbing
// for performance reasons we're only matching one level down:
// 'test/spec/{,*/}*.js'
// use this if you want to recursively match all subfolders:
// 'test/spec/**/*.js'

module.exports = function (grunt) {
  "use strict";
  require('load-grunt-tasks')(grunt);
  require('time-grunt')(grunt);

  // configurable paths
  var yeomanConfig = {
    app: 'src/main/webapp/main',
    dist: 'target/dist'
  };

  try {
    yeomanConfig.app = require('./bower.json').appPath || yeomanConfig.app;
  } catch (e) {}

  grunt.initConfig({
    yeoman: yeomanConfig,
    watch: {
      jshint: {
        files: ['<%= yeoman.app %>/js/{,*/}*.js'],
        tasks: ['jshint']
      },
      coffee: {
        files: ['<%= yeoman.app %>/js/{,*/}*.coffee'],
        tasks: ['coffee']
      },
      sass: {
        files: ['<%= yeoman.app %>/css/{,*/}*.scss'],
        tasks: ['compass']
      }
    },
    clean: {
      dist: {
        files: [{
          dot: true,
          src: [
            '.tmp',
            '<%= yeoman.dist %>/*',
            '!<%= yeoman.dist %>/.git*'
          ]
        }]
      }
    },
    jshint: {
      all: [
        'Gruntfile.js',
        '<%= yeoman.app %>/js/{,*/}*.js'
      ]
    },
    coffee: {
      options: {
        sourceMap: true,
        sourceRoot: ''
      },
      dist: {
        files: [{
          expand: true,
          cwd: '<%= yeoman.app %>/js',
          src: '{,*/}*.coffee',
          dest: '<%= yeoman.dist %>/main/js',
          ext: '.js'
        }]
      }
    },
    compass: {
      dist: {
        options: {
          sassDir: '<%= yeoman.app %>/css',
          cssDir: '<%= yeoman.dist %>/main/css',
        }
      }
    },
    imagemin: {
      dist: {
        files: [{
          expand: true,
          cwd: '<%= yeoman.app %>/image',
          src: '{,*/}*.{png,jpg,jpeg}',
          dest: '<%= yeoman.dist %>/main/image'
        }]
      }
    },
    concurrent: {
      dist: [
        'jshint',
        'coffee',
        'compass',
        'imagemin'
      ]
    }
  });

  grunt.registerTask('build', [
    'clean:dist',
    'concurrent:dist'
  ]);

  grunt.registerTask('default', [
    'build'
  ]);
};
