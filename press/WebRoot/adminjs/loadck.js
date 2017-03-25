var editor = null;
window.onload = function() {
	resizeFormStatus();
    editor = CKEDITOR.replace('detail', {height: '100px', width: '800px'});
    CKFinder.setupCKEditor(editor,'/ckfinder/');
    CKEDITOR.editorConfig = function(config) {
	    //其他一些配置
	    filebrowserBrowseUrl = '/ckfinder/ckfinder.html';
	    filebrowserImageBrowseUrl = '/ckfinder/ckfinder.html?type=Images';
	    filebrowserFlashBrowseUrl = '/ckfinder/ckfinder.html?type=Flash';
	    filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	    filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	    filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
	};
};
