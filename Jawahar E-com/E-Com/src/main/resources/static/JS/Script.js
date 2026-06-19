const videos = document.querySelectorAll('.video-gallery');

   videos.forEach(video => {
     video.autoplay = true;
     video.loop = true;
     video.muted = true;
     video.play();
   });