from django.db import models


# Model for Users
class User(models.Model):
    name = models.CharField(max_length=255)
    email = models.EmailField(null=True)
    age = models.IntegerField(null=True)
    login = models.CharField(max_length=100)
    is_admin = models.BooleanField()
    created_at = models.DateTimeField(auto_now_add=True, null=True)
    updated_at = models.DateTimeField(auto_now=True, null=True)


# Model for Events
class Event(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    type = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    date_start = models.DateTimeField(null=True)
    date_end = models.DateTimeField(null=True)
    is_protected_event = models.BooleanField()
    qr_enable = models.BooleanField()  # TODO
    description = models.CharField(max_length=4000, null=True)
    created_at = models.DateTimeField(auto_now_add=True, null=True)
    updated_at = models.DateTimeField(auto_now=True, null=True)
    # TODO PHOTO


# Model for participants
class Participant(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    event = models.ForeignKey(Event, on_delete=models.CASCADE)


# Model for locations
class Location(models.Model):
    participant = models.ForeignKey(Participant, on_delete=models.CASCADE)
    event = models.ForeignKey(Event, on_delete=models.CASCADE)
    latitude = models.FloatField()
    longitude = models.FloatField()


# Model for checkpoints
class CheckPoint(models.Model):
    name = models.CharField(max_length=255)
    event = models.ForeignKey(Event, on_delete=models.CASCADE)
    latitude = models.FloatField()
    longitude = models.FloatField()
    description = models.CharField(max_length=4000, null=True)
    # TODO PHOTO


# Model for passed checkpoints
class PassedCheckpoints(models.Model):
    participant = models.ForeignKey(Participant, on_delete=models.CASCADE)
    checkpoint = models.ForeignKey(CheckPoint, on_delete=models.CASCADE)
    total_time = models.IntegerField()
    is_questionably = models.BooleanField()
    description = models.CharField(max_length=4000, null=True)


# Model for time slices
class TimeSlices(models.Model):
    checkpoint_from = models.ForeignKey(CheckPoint, on_delete=models.CASCADE, related_name='checkpoint_from')
    checkpoint_to = models.ForeignKey(CheckPoint, on_delete=models.CASCADE, related_name='checkpoint_to')
    event = models.ForeignKey(Event, on_delete=models.CASCADE)
    time_count = models.IntegerField()
