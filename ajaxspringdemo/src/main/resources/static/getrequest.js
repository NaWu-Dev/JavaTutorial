GET: $("#document").ready(
    function () {

        // Get request
        $("#getAllBooks").click(function (event) {

            event.preventDefault();
            ajaxGet();

        });

        // Do get
        function ajaxGet() {
            $.ajax( {
                type : "GET",
                url : "getBooks",
                success : function (result) {
                    if (result.status == "success") {
                        $("#getResultDiv ul").empty();
                        var custList = "";
                        $.each(result.data, function (i, book) {
                            var user = "Book Name " +
                                book.bookName +
                                ", Author = " + book.author + "<br>";
                            $("#getResultDiv .list-group").append(user)
                        })
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("Error");
                        console.log("Fail : ", result);
                    }
                },
                error : function(e) {
                    $("#getResultDiv").html("Error");
                    console.log("ERROR", e);
                }
            });
        }
    }
)