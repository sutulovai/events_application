from rest_framework import serializers

from .models import User, Participant, CheckPoint, Event, Location, PassedCheckpoints, TimeSlices


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'


class ParticipantSerializer(serializers.ModelSerializer):
    class Meta:
        model = Participant
        fields = '__all__'


class CheckPointSerializer(serializers.ModelSerializer):
    class Meta:
        model = CheckPoint
        fields = '__all__'


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = '__all__'


class LocationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Location
        fields = '__all__'


class PassedCheckpointsSerializer(serializers.ModelSerializer):
    class Meta:
        model = PassedCheckpoints
        fields = '__all__'


class TimeSlicesSerializer(serializers.ModelSerializer):
    class Meta:
        model = TimeSlices
        fields = '__all__'
