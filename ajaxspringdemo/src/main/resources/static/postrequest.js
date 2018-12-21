$(document).ready(
    function () {

        // Submit form
        $("#bookForm").submit(function (event) {
            // prevent the form from submitting via browser
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // prepare form data
            var formData = {
                bookId : $("#bookId").val(),
                bookName : $("#bookName").val(),
                author : $("#author").val(),
            }

            // Do post
            $.ajax({
                type: "POST",
                contentType : "application/json",
                url : "saveBook",
                dataType: JSON.stringify(formData),
                success: function(result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html (
                            "" + result.data.bookName +
                            "Post Successfully! <br>" +
                            "----> Congrats!! "
                        )
                    } else {
                        $("#postResultDiv").html("ERROR! ");
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!!!");
                    console.log("ERROR: ", e);

                }
            });

        }

    }
)