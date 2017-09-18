<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>bootstrap contact form</title>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/contact.css">
</head>

<body>

<div class="container">
    <div class="col-md-5">
        <div class="form-area">
            <form role="form"><br style="clear:both"/>
                <h3 style="margin-bottom: 25px; text-align: center">Contact Form</h3>
                <div class="form-group">
                    <input class="form-control" id="name" type="text" name="name" placeholder="Name" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="email" type="text" name="email" placeholder="Email" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="mobile" type="text" name="mobile" placeholder="Mobile Number" required=""/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="subject" type="text" name="subject" placeholder="Subject" required=""/>
                </div>
                <div class="form-group">
                    <textarea class="form-control" id="message" type="textarea" placeholder="Message" maxlength="140" rows="7"></textarea><span class="help-block">
            <p class="help-block" id="characterLeft">0 Left</p></span>
                </div>
                <button class="btn btn-primary pull-right" id="submit" type="button" name="submit">Submit Form</button>
            </form>
        </div>
    </div>
</div>
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>

<script src="js/index.js"></script>

</body>
</html>