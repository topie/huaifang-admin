var outPath = "dist";

var gulp = require('gulp');
var uglify = require('gulp-uglify');
var clean = require('gulp-clean');
var sourcemaps = require('gulp-sourcemaps');
var rev = require('gulp-rev');
var revReplace = require('gulp-rev-replace');
var cssmin = require('gulp-minify-css');
var jsmin = require('gulp-minify');
var connect = require('gulp-connect');
var proxy = require('http-proxy-middleware');
var gutil = require('gulp-util');

gulp.task("build:js", function () {
    // 改动过的js文件压缩 加md5 放到dist的js目录下面
    gulp.src(['src/js/**/*.js'])
        .pipe(uglify())
        .on('error', function (err) {
            gutil.log(gutil.colors.red('[Error]'), err.toString());
        })
        .pipe(rev())
        .pipe(gulp.dest(outPath + "/js/"))
        .pipe(sourcemaps.init())
        .pipe(rev.manifest())
        .pipe(sourcemaps.write('../maps'))
        .pipe(gulp.dest('rev/js'));

});

gulp.task("dev:js", function () {
    // 改动过的js文件压缩 加md5 放到dist的js目录下面
    gulp.src(['src/js/**/*.js'])
        .pipe(jsmin())
        .pipe(rev())
        .pipe(gulp.dest(outPath + "/js/"))
        .pipe(sourcemaps.init())
        .pipe(rev.manifest())
        .pipe(sourcemaps.write('../maps'))
        .pipe(gulp.dest('rev/js'));

});

gulp.task("build:css", function () {

    // css压缩处理
    gulp.src('src/css/**/*.css')
        .pipe(cssmin())
        .pipe(rev())
        .pipe(gulp.dest(outPath + "/css/"))
        .pipe(sourcemaps.init())
        .pipe(rev.manifest())
        .pipe(sourcemaps.write('../maps'))
        .pipe(gulp.dest("rev/css/"));
});


gulp.task("build:cdn", function () {
    // 部分文件直接复制
    gulp.src('src/cdn/**/*.*').pipe(gulp.dest(outPath + "/cdn/"));
    gulp.src('src/fonts/**/*.*').pipe(gulp.dest(outPath + "/fonts/"));

});

gulp.task('replace', function () {
    var options = {
        removeComments: true,//清除HTML注释
        collapseWhitespace: true,
        minifyJS: true,//压缩页面JS
        minifyCSS: true//压缩页面CSS
    };
    var manifest = gulp.src("rev/**/rev-manifest.json");
    return gulp.src("src/*.html")
        .pipe(revReplace({manifest: manifest}))
        .pipe(gulp.dest("dist"));
});

gulp.task('clean', function () {
    return gulp.src([outPath, 'rev']).pipe(clean());
});

gulp.task('build', ['clean', 'build:js', 'build:css', 'build:cdn'], function () {

});
gulp.task('dev', ['dev:js', 'build:css', 'build:cdn'], function () {

});


gulp.task('server', function () {
    connect.server({
        root: [outPath],
        host: 'localhost',
        port: 8002,
        middleware: function (connect, opt) {
            return [
                proxy('/api', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/upload', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/download', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/actuator', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/swagger', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/webjars', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/v2', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                }),
                proxy('/csrf', {
                    target: 'http://127.0.0.1:8080',
                    changeOrigin: true
                })
            ]
        }

    });
});

gulp.task('watch', function () {
    gulp.watch('src/js/**/*.js', ['dev:js']);
    gulp.watch('src/cdn/**/*.js', ['build:cdn']);
    gulp.watch('src/**/*.css', ['build:css']);
    gulp.watch('rev/**/rev-manifest.json', ['replace']);
    gulp.watch('src/*.html', ['replace']);
});