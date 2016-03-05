module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'target/scala-2.11/hellojs-fastopt.js',
                dest: 'target/<%= pkg.name %>.min.js'
            }
        }
    });

    //load plugins
    grunt.loadNpmTasks('grunt-contrib-uglify');

    //register tasks
    grunt.registerTask('default', ['uglify']);
};
