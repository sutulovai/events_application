# Events_app views configuration

from rest_framework import status
from django.db import models
from rest_framework.decorators import api_view
from rest_framework.response import Response

# TODO MUST REFACTORING
from .models import User, Participant, CheckPoint, Event, Location, PassedCheckpoints, TimeSlices
from .serializers import UserSerializer, ParticipantSerializer, CheckPointSerializer, PassedCheckpointsSerializer, \
    TimeSlicesSerializer, LocationSerializer, EventSerializer


@api_view(['GET', 'PUT', 'DELETE'])
def process_users(request, pk):
    try:
        user = User.objects.get(pk=pk)
    except User.DoesNotExist:
        return Response(status=status.HTTP_400_BAD_REQUEST)

    if request.method == 'GET':
        return Response(UserSerializer(user).data)
    elif request.method == 'PUT':
        serializer = UserSerializer(user, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_204_NO_CONTENT)
    elif request.method == 'DELETE':
        user.delete()
        return Response(status=status.HTTP_400_BAD_REQUEST)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'POST'])
def process_users_post_get(request):
    if request.method == 'GET':
        return Response(UserSerializer(User.objects.all(), many=True).data)
    elif request.method == 'POST':
        data = {
            'name': request.data.get('name'),
            'age': request.data.get('age'),
            'email': request.data.get('email'),
            'login': request.data.get('login'),
            'is_admin': request.data.get('is_admin'),
        }
        serializer = UserSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def process_participant(request, pk):
    try:
        participant = Participant.objects.get(pk=pk)
    except Participant.DoesNotExist:
        return Response(status=status.HTTP_400_BAD_REQUEST)

    if request.method == 'GET':
        return Response(ParticipantSerializer(participant).data)
    elif request.method == 'PUT':
        serializer = ParticipantSerializer(participant, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_204_NO_CONTENT)
    elif request.method == 'DELETE':
        participant.delete()
        return Response(status=status.HTTP_400_BAD_REQUEST)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'POST'])
def process_participant_post_get(request):
    if request.method == 'GET':
        return Response(ParticipantSerializer(User.objects.all(), many=True).data)
    elif request.method == 'POST':
        data = {
            'event_id': request.data.get('event_id'),
            'user_id': request.data.get('user_id'),
        }
        serializer = ParticipantSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def process_event(request, pk):
    try:
        event = Event.objects.get(pk=pk)
    except Event.DoesNotExist:
        return Response(status=status.HTTP_400_BAD_REQUEST)

    if request.method == 'GET':
        return Response(EventSerializer(event).data)
    elif request.method == 'PUT':
        serializer = EventSerializer(event, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_204_NO_CONTENT)
    elif request.method == 'DELETE':
        event.delete()
        return Response(status=status.HTTP_400_BAD_REQUEST)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'POST'])
def process_event_post_get(request):
    if request.method == 'GET':
        return Response(EventSerializer(Event.objects.all(), many=True).data)
    elif request.method == 'POST':
        data = {
            'type': request.data.get('type'),
            'name': request.data.get('name'),
            'is_protected_event': request.data.get('is_protected_event'),
            'qr_enable': request.data.get('qr_enable'),
            'description': request.data.get('description'),
            'user_id': request.data.get('user_id'),
        }
        serializer = EventSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def process_checkpoint(request, pk):
    try:
        checkPoint = CheckPoint.objects.get(pk=pk)
    except CheckPoint.DoesNotExist:
        return Response(status=status.HTTP_400_BAD_REQUEST)

    if request.method == 'GET':
        return Response(CheckPointSerializer(checkPoint).data)
    elif request.method == 'PUT':
        serializer = CheckPointSerializer(checkPoint, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_204_NO_CONTENT)
    elif request.method == 'DELETE':
        checkPoint.delete()
        return Response(status=status.HTTP_400_BAD_REQUEST)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'POST'])
def process_check_point_post_get(request):
    if request.method == 'GET':
        return Response(CheckPointSerializer(CheckPoint.objects.all(), many=True).data)
    elif request.method == 'POST':
        data = {
            'name': request.data.get('name'),
            'latitude': request.data.get('latitude'),
            'longitude': request.data.get('longitude'),
            'description': request.data.get('description'),
            'event_id': request.data.get('event_id'),
        }
        serializer = CheckPointSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def process_passed_check_point(request, pk):
    try:
        checkpoint = PassedCheckpoints.objects.get(pk=pk)
    except Event.DoesNotExist:
        return Response(status=status.HTTP_400_BAD_REQUEST)

    if request.method == 'GET':
        return Response(PassedCheckpointsSerializer(checkpoint).data)
    elif request.method == 'PUT':
        serializer = PassedCheckpointsSerializer(checkpoint, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_204_NO_CONTENT)
    elif request.method == 'DELETE':
        checkpoint.delete()
        return Response(status=status.HTTP_400_BAD_REQUEST)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'POST'])
def process_passed_check_point_post_get(request):
    if request.method == 'GET':
        return Response(PassedCheckpointsSerializer(PassedCheckpoints.objects.all(), many=True).data)
    elif request.method == 'POST':
        data = {
            'total_time': request.data.get('total_time'),
            'is_questionably': request.data.get('is_questionably'),
            'description': request.data.get('description'),
            'checkpoint_id': request.data.get('checkpoint_id'),
            'participant_id': request.data.get('participant_id'),
        }
        serializer = PassedCheckpointsSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(status=status.HTTP_201_CREATED)
    else:
        return Response(status=status.HTTP_400_BAD_REQUEST)
